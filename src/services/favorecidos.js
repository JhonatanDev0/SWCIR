import api from './api';
const endpoint = '/favorecidos';

const cadastrarFavorecidos = (body) => {
    return api.post(`${endpoint}/add`, body);
};

const userServicesFav = {
    cadastrarFavorecidos,
};

export default userServicesFav;