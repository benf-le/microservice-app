"use client";

import {useEffect, useState} from "react";
import {Products} from "@/models/Products";
import HandleProducts from "@/api/HandleProducts";
import Navbar from "@/components/Navbar";
import {usePathname} from "next/navigation";
import axios from "axios";
export default function ProductDetail() {

    const [productDetail, setProductDetail] = useState() //Products co dang array

    // const {id} = useParams() // lấy ra id từ query param
    const id = usePathname();

    console.log(id)



// đợi backend có thể setup xong việc lấy data từ id

    useEffect(() => {
        id&&
        getProductsById()
    }, [id])
    const getProductsById = async () => {

        const api = `${id}`

        try {
            const res:any = fetch(`http://localhost:8000${api}`)
            // console.log(res)

                setProductDetail(res)

        } catch (e) {
            // @ts-ignore
            console.log(`Product not found: ${e.message}`)
        }

        console.log(productDetail)

        return (
            <div>


            </div>
        )


    }
}
