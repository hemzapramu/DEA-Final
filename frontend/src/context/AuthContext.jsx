import React, { createContext, useContext, useState, useEffect } from 'react';
import api from '../api/client';

const AuthContext = createContext(null);

export const AuthProvider = ({ children }) => {
    const [user, setUser] = useState(null);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const userStr = localStorage.getItem('user');
        if (userStr) {
            setUser(JSON.parse(userStr));
        }
        setLoading(false);
    }, []);

    const login = async (email, password) => {
        try {
            // Encode credentials
            const auth = btoa(`${email}:${password}`);
            // Verify with backend (mock call to /login which is just a check, or /my/profile if implemented)
            // But we can just try to hit an endpoint.
            // For now, let's just assume if backend returns 200 on /api/auth/login we are good.

            // We need to send headers manually here because interceptor might not have them yet or we want to override
            const response = await api.post('/auth/login', { email, password });

            const userData = { email, auth, name: response.data.name || email, role: response.data.role };
            localStorage.setItem('user', JSON.stringify(userData));
            setUser(userData);
            return true;
        } catch (error) {
            console.error("Login failed", error);
            throw error;
        }
    };

    const register = async (name, email, password, role) => {
        await api.post('/auth/register', { name, email, password, role });
        return true;
    };

    const logout = () => {
        localStorage.removeItem('user');
        setUser(null);
    };

    return (
        <AuthContext.Provider value={{ user, login, register, logout, loading }}>
            {children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => useContext(AuthContext);
