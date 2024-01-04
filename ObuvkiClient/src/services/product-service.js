import axios from 'axios';

const baseUrl = 'http://localhost:8080/'; //

export const getAllProducts =  async () =>{
    const url = `${baseUrl}api/v1/products`
    const response = await axios.get(`${url}`, {
        headers: {
          Authorization: `Bearer ${localStorage.getItem('accessToken')}`,
        },
      });
    return response.data;
}