import api from './api';
const endpoint = '/fav';

const cadastrarFavorecidos = (body) => {
    return api.post(`${endpoint}/`, body);
};

const puxarDadoFav = () => {
    return api.get(`${endpoint}/`)
}

const excluirDadoFav = (fav_id) => {
    return api.delete(`${endpoint}/${fav_id}`)
}

const userServicesFav = {
    cadastrarFavorecidos,
    puxarDadoFav,
    excluirDadoFav,
};

export default userServicesFav;