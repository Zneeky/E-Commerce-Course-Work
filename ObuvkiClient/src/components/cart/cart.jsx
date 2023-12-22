import React, { Component } from 'react'
import Title from '../title.jsx';
import CartColumns from './cart-columns.jsx';
import EmptyCart from './empty-cart.jsx';
import { ProductConsumer} from '../../contexts/product-context.jsx';
import CartList from './cart-list.jsx';
import CartTotals from "./cart-totals.jsx";

export default class Store extends Component {
    render() {
        return (
            <section>
                <ProductConsumer>
                    {value => {
                        const { cart } = value;
                        if (cart.length > 0) {
                            return (
                                <React.Fragment>
                                    <Title name="your" title="cart" />
                                    <CartColumns />
                                    <CartList value={value} />
                                    <CartTotals value={value} />
                                </React.Fragment>
                            );
                        } else {
                            return <EmptyCart />;
                        }
                    }}
                </ProductConsumer>
            </section>
        );
    }
}