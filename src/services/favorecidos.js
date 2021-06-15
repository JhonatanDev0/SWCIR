import api from './api';
const endpoint = '/fav';

const cadastrarFavorecidos = (body) => {
    return api.post(`${endpoint}/`, body);
};

const userServicesFav = {
    cadastrarFavorecidos,
};

export default userServicesFav;