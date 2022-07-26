import React from 'react'
import { TextField, Alert, Box, Form, Button } from "@mui/material";
import { useForm } from "react-hook-form";
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import ProductService from "../services/ProductService";


class ProductDetails extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            product: {},
            productName:"",
            details:"",
            cost:0
        }
    }

    async componentDidMount() {
//        const params = useParams();
       const id = window.location.href.split('/')[4]
       await ProductService.getOneProduct(id).then((response) => {
            this.setState({product: response.data})
       })
    }

    handleSubmit(event){
    event.preventDefault()
        const id = event.target.elements.idField.value
        const productName = event.target.elements.nameField.value
        const details = event.target.elements.descField.value
        const cost = event.target.elements.priceField.value
        const updatedProduct = {id,productName, cost, details}
        ProductService.updateProduct(updatedProduct);
        window.location.reload();
    }


    render(){
    return (
        <>
            <Box>
                <form onSubmit={this.handleSubmit}>
                    <br />
                    <TextField
                        disabled
                        name="idField"
                        label="Product ID"
                        style={{ width: "300px" }}
                        type="number"
                        variant="outlined"
                        multiline
                        defaultValue={this.state.product.id}
                    />
                    <br />
                    <br />
                    <TextField
                        name="nameField"
                        style={{ width: "300px" }}
                        label="Product Name"
                        type="text"
                        variant="outlined"
                        multiline
                        defaultValue={this.state.product.productName}
                    />
                    <br />
                    <br />
                    <TextField
                        name="priceField"
                        label="Price"
                        style={{ width: "300px" }}
                        type="number"
                        variant="outlined"
                        multiline
                        defaultValue={this.state.product.cost}
                    />
                    <br />
                    <br />
                    <TextField
                        name="descField"
                        label="Description"
                        style={{ width: "300px" }}
                        type="text"
                        variant="outlined"
                        multiline
                        defaultValue={this.state.product.details}
                    />
                    <br />
                    <Button variant="contained" color="primary" type="submit">
                        Update
                    </Button>
                    <br />
                    <br />
                </form>
                <br />
            </Box>
        </>
    );}
}

export default ProductDetails;