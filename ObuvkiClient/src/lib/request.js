// const buildOptions = (data) => {
//     const options = {};

//     if (data) {
//         options.body = JSON.stringify(data);
//         options.headers = {
//             'content-type': 'application/json'
//         };
//     }
//     const token = localStorage.getItem('accessToken');

//     if (token) {
//         options.headers = {
//             'Authorization' : `Bearer ${token}`
//         };
//     }

//     return options;
// };

// const request = async (method, url, data) => {
//     const response = await fetch(url, {
//         ...buildOptions(data),
//         method,
//     });

//     console.log('Server Response:', response);

//     const result = await response.json();
//     return result;
// };

// export const get = request.bind(null, 'GET');
// export const post = request.bind(null, 'POST');
// export const put = request.bind(null, 'PUT');
// export const remove = request.bind(null, 'DELETE');
import axios from 'axios';

const buildOptions = () => {
    const headers = {
        'Content-Type': 'application/json'
    };

    const token = localStorage.getItem('accessToken');
    if (token) {
        headers['Authorization'] = `Bearer ${token}`;
    }

    return { headers };
};

const request = async (method, url, data = null) => {
    try {
        const response = await axios({
            method,
            url,
            data,
            ...buildOptions()
        });

        return response.data;
    } catch (error) {
        console.error('Error during Axios request:', error.message);
        // Handle or throw the error based on your use case
        throw error;
    }
};

export const get = (url, data) => request('get', url, data);
export const post = (url, data) => request('post', url, data);
export const put = (url, data) => request('put', url, data);
export const remove = (url, data) => request('delete', url, data);
