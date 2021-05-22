import api from './api';
const endpoint = '/dependentes';

const cadastrarDependentes = (body) => {
    return api.post(`${endpoint}/add`, body);
};

const userServices = {
    cadastrarDependentes,
};

export default userServices;