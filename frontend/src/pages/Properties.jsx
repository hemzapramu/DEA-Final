import React, { useEffect, useState } from 'react';
import api from '../api/client';
import './Properties.css';

const Properties = () => {
    const [properties, setProperties] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchProperties = async () => {
            try {
                const response = await api.get('/properties');
                setProperties(response.data);
            } catch (error) {
                console.error("Failed to fetch properties", error);
            } finally {
                setLoading(false);
            }
        };
        fetchProperties();
    }, []);

    if (loading) return <div className="loading">Loading properties...</div>;

    return (
        <div className="properties-page">
            <h1 className="page-title">Available Properties</h1>

            <div className="properties-grid">
                {properties.map(property => (
                    <div key={property.id} className="property-card">
                        <div className="property-image" style={{ backgroundColor: '#e2e8f0', height: '200px' }}>
                            {/* Placeholder for image */}
                            <div style={{ display: 'flex', alignItems: 'center', justifyContent: 'center', height: '100%', color: '#94a3b8' }}>No Image</div>
                        </div>
                        <div className="property-content">
                            <div className="property-price">${property.price?.toLocaleString()}</div>
                            <h3 className="property-title">{property.title}</h3>
                            <p className="property-address">{property.address}</p>
                            <div className="property-features">
                                <span>{property.bedrooms} Beds</span>
                                <span>{property.bathrooms} Baths</span>
                                <span>{property.areaSqFt} sqft</span>
                            </div>
                            <button className="view-button">View Details</button>
                        </div>
                    </div>
                ))}
            </div>

            {properties.length === 0 && (
                <div className="no-results">No properties found. Check back later!</div>
            )}
        </div>
    );
};

export default Properties;
