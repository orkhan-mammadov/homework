import React from "react";
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import ProductService from "../services/ProductService";
import Button from '@mui/material/Button';

class Products extends React.Component {

    constructor(props) {
        super(props)
        this.state = {
            data: []
        }
    }

    async componentDidMount() {

       await ProductService.getProducts().then((response) => {
            this.setState({data: response.data.products})
       })
    }

    handleClick(id){
        ProductService.deleteProduct(id);
        window.location.reload();
    }

    render() {

        return (
            <TableContainer component={Paper}>
                <h1 className="text-center">Products</h1>
                <Table sx={{ minWidth: 650 }} aria-label="simple table">
                    <TableHead>
                        <TableRow>
                            <TableCell align="right">Product ID</TableCell>
                            <TableCell align="right">Product Name</TableCell>
                            <TableCell align="right">Description</TableCell>
                            <TableCell align="right">Price</TableCell>
                            <TableCell align="right">Actions</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {this.state.data.map(data =>
                         <TableRow>
                         <TableCell align="right">{data.id}</TableCell>
                         <TableCell align="right">{data.productName}</TableCell>
                         <TableCell align="right">{data.details}</TableCell>
                         <TableCell align="right">{data.cost}</TableCell>
                         <TableCell align='right'>
                         <Button variant="contained" color="success"><a href={"/product/"+data.id}>View</a></Button>
                         </TableCell>
                         <TableCell align='right'>
                         <Button variant="contained" color="error" onClick={()=>this.handleClick(data.id)}>Delete</Button>
                         </TableCell>
                         </TableRow>
                       )}

                    </TableBody>
                </Table>
            </TableContainer>
        )
    }
}

export default Products;