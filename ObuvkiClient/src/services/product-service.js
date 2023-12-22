import * as request from '../lib/request';

const baseUrl = 'http://localhost:8080/'; //

export const getAllProducts =  async () =>{
    const url = `${baseUrl}products`
    return await request.get(url);
}