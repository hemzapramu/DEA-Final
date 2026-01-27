import React from 'react';
import Hero from '../components/Hero';
import { Link } from 'react-router-dom';

const Home = () => {
    return (
        <div>
            <Hero />
            <section style={{ padding: '4rem 0', maxWidth: '1200px', margin: '0 auto' }}>
                <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '2rem' }}>
                    <h2 style={{ fontSize: '2rem', color: 'var(--text-color)' }}>Featured Properties</h2>
                    <Link to="/properties" style={{ color: 'var(--primary-color)', fontWeight: 'bold' }}>View All &rarr;</Link>
                </div>

                <div style={{ textAlign: 'center', padding: '2rem', background: '#f1f5f9', borderRadius: 'var(--border-radius)' }}>
                    <p>Start your search by browsing our latest listings.</p>
                </div>
            </section>
        </div>
    );
};

export default Home;
