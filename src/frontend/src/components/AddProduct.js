import React from 'react'
import { TextField, Alert, Box, Form, Button } from "@mui/material";
import { useForm } from "react-hook-form";
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";
import ProductService from "../services/ProductService";


class AddProduct extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            product: {},
            productName:"",
            details:"",
            cost:0
        }
    }


    handleSubmit(event){
    event.preventDefault()
        const productName = event.target.elements.nameField.value
        const details = event.target.elements.descField.value
        const cost = event.target.elements.priceField.value
        const newProduct = {productName, cost, details}
        ProductService.addProduct(newProduct);
        window.location.replace("http://localhost:3000");
    }


    render(){
    return (
        <>
            <Box>
                <form onSubmit={this.handleSubmit}>
                    <TextField
                        name="nameField"
                        style={{ width: "300px" }}
                        label="Product Name"
                        type="text"
                        variant="outlined"
                        multiline
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
                    />
                    <br />
                    <Button variant="contained" color="primary" type="submit">
                        Add Product
                    </Button>
                    <br />
                    <br />
                </form>
                <br />
            </Box>
        </>
    );}
}

export default AddProduct;