import axios from "axios";

const PRODUCTS_REST_API_URL = "http://localhost:8080/api/product/"

// axios.get('https://example.com/getSomething', {
//  headers: {
//    Authorization: 'Bearer ' + token 
//  }
// })

class ProductService {
    getProducts() {
        return axios.get(PRODUCTS_REST_API_URL);
    }

    getOneProduct(id) {
        return axios.get(PRODUCTS_REST_API_URL + id)
    }

    deleteProduct(id){
        return axios.delete(PRODUCTS_REST_API_URL + id)
    }

    updateProduct(updatedProduct){
        return axios.put(PRODUCTS_REST_API_URL, updatedProduct)
    }

    addProduct(newProduct){
        return axios.post(PRODUCTS_REST_API_URL,newProduct)
    }
}

export default new ProductService();