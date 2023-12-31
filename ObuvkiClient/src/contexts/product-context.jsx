import React, { Component } from "react";
import { storeProducts, detailProduct } from "../test/data";
import {
    addProductToCart,
    getAllCartProducts,
    deleteProductInCart,
    deleteAllInCart,
    addQuantityToProduct,
    decreaseQuantityToProduct
  } from '../services/cart-service';
import { getAllProducts } from '../services/product-service';
const ProductContext = React.createContext();

class ProductProvider extends Component {
    state = {
        products: [],
        detailProduct: detailProduct,
        cart: [],
        modalOpen: false,
        modalProduct: detailProduct,
        cartSubTotal: 0,
        cartTax: 0,
        cartTotal: 0
    };
    componentDidMount() {
        this.setProducts();
        this.setProductsInCart();
    }

    //ORIGINAL METHOD WHEN USING IN STORE DATA
    // setProducts = () => {
    //     let products = [];
    //     storeProducts.forEach(item => {
    //         const singleItem = { ...item };
    //         products = [...products, singleItem];
    //     });
    //     this.setState(() => {
    //         return { products };
    //     }, this.checkCartItems);
    // };
    setProducts = async () => {
        try {
            const response = await getAllProducts();
            const products = response.map(item => ({ ...item }));
            this.setState(() => {
                return { products };
            }, this.checkCartItems);
        } catch (error) {
            console.error("Error fetching products:", error);
        }
    };

    getItem = id => {
        const product = this.state.products.find(item => item.id === id);
        return product;
    };
    handleDetail = id => {
        const product = this.getItem(id);
        this.setState(() => {
            return { detailProduct: product };
        });
    };
    setProductsInCart = async () => {
        try {
            const userId = localStorage.getItem("userId");
            const response = await getAllCartProducts(userId);
            if (response) {
                let tempProducts = [...this.state.products];
                let cartProducts = response;
    
                tempProducts.forEach(product => {
                    product.inCart = cartProducts.some(cartItem => cartItem.id === product.id);
                });
    
                this.setState(() => {
                    return { 
                        cart: cartProducts,
                        products: tempProducts
                    };
                });
            } else {
                console.error("Invalid response structure:", response);
            }
        } catch (error) {
            console.error("Error fetching cart products:", error);
        }
    };
    addToCart = async id => {
        const userId = localStorage.getItem("userId");
        let tempProducts = [...this.state.products];
        const index = tempProducts.indexOf(this.getItem(id));
        const product = tempProducts[index];
        product.inCart = true;
        product.quantity = 1;
        const price = product.price;
        product.total = price;

        this.setState(() => {
            return {
                products: [...tempProducts],
                cart: [...this.state.cart, product],
                detailProduct: { ...product }
            };
        }, this.addTotals);
        await addProductToCart(id, userId)
    };
    openModal = id => {
        const product = this.getItem(id);
        this.setState(() => {
            return { modalProduct: product, modalOpen: true };
        });
    };
    closeModal = () => {
        this.setState(() => {
            return { modalOpen: false };
        });
    };
    increment = async id => {
        let tempCart = [...this.state.cart];
        const selectedProduct = tempCart.find(item => {
            return item.id === id;
        });
        const index = tempCart.indexOf(selectedProduct);
        const product = tempCart[index];
        product.quantity = product.quantity + 1;
        product.total = product.quantity * product.price;
        this.setState(() => {
            return {
                cart: [...tempCart]
            };
        }, this.addTotals);
        
        const userId = localStorage.getItem("userId");
        await addQuantityToProduct(id,userId)
    };
    decrement = async id => {
        let tempCart = [...this.state.cart];
        const selectedProduct = tempCart.find(item => {
            return item.id === id;
        });
        const index = tempCart.indexOf(selectedProduct);
        const product = tempCart[index];
        product.quantity = product.quantity - 1;
        if (product.quantity === 0) {
            this.removeItem(id);
        } else {
            product.total = product.quantity * product.price;
            this.setState(() => {
                return { cart: [...tempCart] };
            }, this.addTotals);
        }

        const userId = localStorage.getItem("userId");
        await decreaseQuantityToProduct(id, userId)
    };
    getTotals = () => {
        // const subTotal = this.state.cart
        //   .map(item => item.total)
        //   .reduce((acc, curr) => {
        //     acc = acc + curr;
        //     return acc;
        //   }, 0);
        let subTotal = 0;
        this.state.cart.map(item => (subTotal += item.total));
        const tempTax = subTotal * 0.1;
        const tax = parseFloat(tempTax.toFixed(2));
        const total = subTotal + tax;
        return {
            subTotal,
            tax,
            total
        };
    };
    addTotals = () => {
        const totals = this.getTotals();
        this.setState(
            () => {
                return {
                    cartSubTotal: totals.subTotal,
                    cartTax: totals.tax,
                    cartTotal: totals.total
                };
            },
            () => {
                // console.log(this.state);
            }
        );
    };
    removeItem = async id => {
        let tempProducts = [...this.state.products];
        let tempCart = [...this.state.cart];

        const index = tempProducts.indexOf(this.getItem(id));
        let removedProduct = tempProducts[index];
        removedProduct.inCart = false;
        removedProduct.quantity = 0;
        removedProduct.total = 0;

        tempCart = tempCart.filter(item => {
            return item.id !== id;
        });

        this.setState(() => {
            return {
                cart: [...tempCart],
                products: [...tempProducts]
            };
        }, this.addTotals);

        const userId = localStorage.getItem("userId");
        await deleteProductInCart(id, userId);
        
    };
    clearCart = async () => {
        this.setState(
            () => {
                const userId = localStorage.getItem("userId");
                deleteAllInCart(userId)
                return { cart: [] };
            },
            () => {
                this.setProducts();
                this.addTotals();
            }
        );

        const userId = localStorage.getItem("userId");
        await deleteAllInCart(userId)
    };
    render() {
        return (
            <ProductContext.Provider
                value={{
                    ...this.state,
                    handleDetail: this.handleDetail,
                    setProductsInCart:this.setProductsInCart,
                    addToCart: this.addToCart,
                    openModal: this.openModal,
                    closeModal: this.closeModal,
                    increment: this.increment,
                    decrement: this.decrement,
                    removeItem: this.removeItem,
                    clearCart: this.clearCart
                }}
            >
                {this.props.children}
            </ProductContext.Provider>
        );
    }
}

const ProductConsumer = ProductContext.Consumer;

export { ProductProvider, ProductConsumer };
