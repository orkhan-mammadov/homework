import React, { useState } from 'react';
import UserService from '../services/UserService';

const UserComponent = ({ user }) => {
    
    // UserService.getUsers().then((response) => {
    //     this.setState({ users: response.data })
    // })
    
    return (
        <div>
            <h1 className='text-center'>Welcome, {user}</h1>
        </div>
    )
}

export default UserComponent;