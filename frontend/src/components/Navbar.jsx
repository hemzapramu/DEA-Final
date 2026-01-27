import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';

const Navbar = () => {
    const { user, logout } = useAuth();
    const navigate = useNavigate();

    const handleLogout = () => {
        logout();
        navigate('/login');
    };

    const styles = {
        nav: {
            display: 'flex',
            justifyContent: 'space-between',
            alignItems: 'center',
            padding: '1rem 0',
            borderBottom: '1px solid #e2e8f0',
            marginBottom: '2rem'
        },
        logo: {
            fontSize: '1.5rem',
            fontWeight: 'bold',
            color: 'var(--primary-color)',
            textDecoration: 'none'
        },
        links: {
            display: 'flex',
            gap: '2rem',
            alignItems: 'center'
        },
        link: {
            fontWeight: '500',
            cursor: 'pointer',
            color: 'var(--text-color)',
            textDecoration: 'none'
        },
        button: {
            backgroundColor: 'var(--primary-color)',
            color: 'white',
            padding: '0.5rem 1rem',
            borderRadius: 'var(--border-radius)',
            fontWeight: '500',
            textDecoration: 'none'
        },
        userSection: {
            display: 'flex',
            alignItems: 'center',
            gap: '1rem'
        }
    };

    return (
        <nav style={styles.nav}>
            <Link to="/" style={styles.logo}>EstateManager</Link>
            <div style={styles.links}>
                <Link to="/properties" style={styles.link}>Properties</Link>
                <Link to="#" style={styles.link}>Agents</Link>

                {user ? (
                    <div style={styles.userSection}>
                        <span>Welcome, {user.name}</span>
                        <button onClick={handleLogout} style={{ ...styles.button, backgroundColor: '#cbd5e1', color: 'black' }}>Logout</button>
                    </div>
                ) : (
                    <div style={styles.links}>
                        <Link to="/login" style={styles.link}>Login</Link>
                        <Link to="/register" style={styles.button}>Get Started</Link>
                    </div>
                )}
            </div>
        </nav>
    );
};

export default Navbar;
