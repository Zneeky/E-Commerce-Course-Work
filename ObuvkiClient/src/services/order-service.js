import * as request from '../lib/request';

const baseUrl = 'http://localhost:8080/api/v1/order/'; 

export const createOrder = async (userId, supplierId=1) => {
    const url = `${baseUrl}create/${userId}/${supplierId}`;
    return await request.post(url);
}