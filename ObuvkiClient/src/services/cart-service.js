import * as request from '../lib/request';

const baseUrl = 'http://localhost:8080/'; //

export const addProductToCart = async (productId, userId) => {
    const url = `${baseUrl}addProductToCart?productId=${productId}&userId=${userId}`;
    return await request.put(url);
};

export const getAllCartProducts = async (userId) => {
    const url = `${baseUrl}${userId}`;
    return await request.get(url);
};

export const deleteProductInCart = async (productId, userId) => {
    const url = `${baseUrl}deleteInCart?productId=${productId}&userId=${userId}`;
    return await request.remove(url);
};

export const deleteAllInCart = async (userId) => {
    const url = `${baseUrl}deleteAllInCart?userId=${userId}`;
    return await request.remove(url);
};

export const addQuantityToProduct = async (productId, userId) => {
    const url = `${baseUrl}addQuantity?productId=${productId}&userId=${userId}`;
    return await request.patch(url);
};

export const decreaseQuantityToProduct = async (productId, userId) => {
    const url = `${baseUrl}decreaseQuantity?productId=${productId}&userId=${userId}`;
    return await request.patch(url);
};