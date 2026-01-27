import React from 'react';

const Hero = () => {
    const styles = {
        hero: {
            textAlign: 'center',
            padding: '4rem 0',
            backgroundColor: 'var(--card-bg)',
            borderRadius: 'var(--border-radius)',
            boxShadow: 'var(--shadow)',
            marginBottom: '2rem'
        },
        title: {
            fontSize: '2.5rem',
            marginBottom: '1rem',
            color: 'var(--text-color)'
        },
        subtitle: {
            fontSize: '1.1rem',
            color: '#64748b',
            marginBottom: '2rem'
        },
        searchBox: {
            display: 'flex',
            justifyContent: 'center',
            gap: '1rem',
            maxWidth: '600px',
            margin: '0 auto'
        },
        input: {
            flex: 1,
            padding: '0.75rem',
            borderRadius: 'var(--border-radius)',
            border: '1px solid #cbd5e1',
            fontSize: '1rem'
        },
        button: {
            backgroundColor: 'var(--primary-color)',
            color: 'white',
            padding: '0.75rem 1.5rem',
            borderRadius: 'var(--border-radius)',
            fontSize: '1rem',
            fontWeight: 'bold'
        }
    };

    return (
        <div style={styles.hero}>
            <h1 style={styles.title}>Find Your Dream Home</h1>
            <p style={styles.subtitle}>Search properties for sale and rent in your area</p>

            <div style={styles.searchBox}>
                <input
                    type="text"
                    placeholder="Enter location, property type, or keyword..."
                    style={styles.input}
                />
                <button style={styles.button}>Search</button>
            </div>
        </div>
    );
};

export default Hero;
