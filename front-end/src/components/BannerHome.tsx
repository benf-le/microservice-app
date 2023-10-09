import React from 'react';

function BannerHome(props) {
    return (
        <div>
            <div>
                <div
                    className="hero"
                    style={{
                        backgroundImage:
                            "url(https://daisyui.com/images/stock/photo-1507358522600-9f71e620c44e.jpg)",
                    }}
                >
                    <div className="hero-overlay h-80 bg-opacity-60"></div>
                </div>
            </div>


        </div>
    );
}

export default BannerHome;