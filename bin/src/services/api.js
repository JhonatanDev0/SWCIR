import axios from 'axios';

export const baseURL = 'http://localhost:8090/';

const api = axios.create({
    baseURL : baseURL,
    Headers: {
        'Content-Type': 'application/json',
        'Acess-Control-Allow-Origin': `*`,
    },
});

export default api;