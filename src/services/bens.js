import api from './api';
const endpoint = '/bem';

const cadastrarBens = (body) => {
    return api.post(`${endpoint}/`, body);
};

const userServicesBens = {
    cadastrarBens,
};

export default userServicesBens;