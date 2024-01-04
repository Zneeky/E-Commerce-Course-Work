import * as request from '../lib/request';

const baseUrl = 'http://localhost:8080/'; //

export const getAllProducts =  async () =>{
    const url = `${baseUrl}api/v1/products`
    return await request.get(url);
}