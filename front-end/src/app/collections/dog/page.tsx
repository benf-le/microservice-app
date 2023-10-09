import React from "react";
import Navbar from "@/components/Navbar";
import Footer from "@/components/Footer";
import MenuCollection from "@/components/MenuCollection";
import ProductsCard from "@/components/ProductsCard";

function CollectionDog(props) {
    return (
        <div>
            <Navbar/>
            <div className="px-20">
                <div className="pet-stock-text-color py-10 text-5xl font-semibold">
                    DOG SUPPLIES
                </div>


                    <main className="flex flex-row ">
                        <div1 className="basis-1/4">
                            <MenuCollection/>
                        </div1>
                        <div2 className=" basis-3/4 grid ">

                            <ProductsCard/>

                        </div2>
                    </main>

            </div>
            <Footer/>
        </div>
    );
}

export default CollectionDog;
