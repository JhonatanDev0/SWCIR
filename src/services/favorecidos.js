import api from './api';
const endpoint = '/favorecidos';

const cadastrarfavorecidos = (body) => {
    return api.post(`${endpoint}/add`, body);
};

const userServices = {
    cadastrarfavorecidos,
};

export default userServices;