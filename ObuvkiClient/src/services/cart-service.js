import * as request from '../lib/request';

const baseUrl = 'http://localhost:8080/api/v1/cart/'; //

export const addProductToCart = async (productId, userId) => {
    const url = `${baseUrl}addProductToCart/${productId}/${userId}`;
    return await request.put(url);
};

export const getAllCartProducts = async (userId) => {
    const url = `${baseUrl}${userId}`;
    return await request.get(url);
};

export const deleteProductInCart = async (productId, userId) => {
    const url = `${baseUrl}deleteInCart/${productId}/${userId}`;
    return await request.remove(url);
};

export const deleteAllInCart = async (userId) => {
    const url = `${baseUrl}deleteAllInCart/${userId}`;
    return await request.remove(url);
};

export const addQuantityToProduct = async (productId, userId) => {
    const url = `${baseUrl}addQuantity/${productId}/${userId}`;
    return await request.patch(url);
};

export const decreaseQuantityToProduct = async (productId, userId) => {
    const url = `${baseUrl}decreaseQuantity/${productId}/${userId}`;
    return await request.patch(url);
};