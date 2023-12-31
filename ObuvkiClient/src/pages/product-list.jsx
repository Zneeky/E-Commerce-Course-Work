import React, { Component } from 'react';
import Product from "../components/product";
import Title from '../components/title';
import { ProductConsumer } from '../contexts/product-context';

export default class ProductList extends Component {
    render() {
        return (
            <React.Fragment>
                <div className="py-5">
                    <div className="container">
                        <Title name="our" title="products" />
                        <div className="row">
                            <ProductConsumer>
                                {value => {
                                    if (value.products.length === 0) {
                                        // Render a loading indicator or a message
                                        return <div>Loading products...</div>;
                                    }
                                    return value.products.map(product => {
                                        return <Product key={product.id} product={product} />;
                                    });
                                }}
                            </ProductConsumer>
                        </div>
                    </div>
                </div>
            </React.Fragment>
        );
    }
}
