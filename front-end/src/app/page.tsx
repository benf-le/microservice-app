
import Navbar from "@/components/Navbar";
import Footer from "@/components/Footer";
import ProductsCardSale from "@/components/ProductsCardSale";
import React from "react";
import axios from "axios";
import BannerHome from "@/components/BannerHome";

export default async function Home() {


        return (
            <div>
                <Navbar/>
                <BannerHome/> 


                   <ProductsCardSale/>


                <Footer/>
            </div>
        );
}
