import api from './api';
const endpoint = '/dependentes';

const cadastrarDependentes = (body) => {
    return api.post(`${endpoint}/add`, body);
};

const userServicesDep = {
    cadastrarDependentes,
};

export default userServicesDep;