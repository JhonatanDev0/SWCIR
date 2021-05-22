import api from './api';
const endpoint = '/user';

const cadastrarUsuario = (body) => {
    return api.post(`${endpoint}/add`, body);
};

const userServices = {
    cadastrarUsuario,
};

export default userServices;