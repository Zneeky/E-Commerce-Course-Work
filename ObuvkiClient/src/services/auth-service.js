import * as request from '../lib/request';

const baseUrl = 'http://localhost:8080/'; //

export const login = async (email, password) => {
    const result = await request.post(`${baseUrl}api/v1/auth/signin`, {
        email,
        password,
    });

    return result;
};

export const register = (email, username, password) => request.post(`${baseUrl}api/v1/auth/signup`, {
    email,
    username,
    password,
});

export const logout = () => request.get(`${baseUrl}/logout`);