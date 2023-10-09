
import React from "react";
import Navbar from "@/components/Navbar";
import Link from "next/link";
import axios from "axios";
import { useRouter } from 'next/navigation'; // nếu dùng "use client" thì dùng from 'next/navigation', còn lại thì dùng from 'next/router';
function Page(props) {
    const router = useRouter(); //dùng để quản lý điều hướng trong Next.js

    const [user, setUser] = React.useState({
        firstName: '',
        lastName: '',
        email: '',
        password: ''

    })

    const [confirmPassword, setConfirmPassword] = React.useState<string>(null) //Sử dụng <string> là cách để cho TypeScript biết rằng confirmPassword là một biến có kiểu dữ liệu là chuỗi.
    // const [password, setPassword] = React.useState({ })
    const [error, setError] = React.useState<string>(null)

    const onSignUp = async (e) => {

        e.preventDefault() //chặn reload trang
        try {
            if (user.password !== confirmPassword) {
                setError('Password needs to match!')
                return

            } else {
                const response = await axios.post(`http://localhost:8000/register`, user)


                if (response.status === 201) {
                    // Đăng ký thành công
                    // Sau khi đăng ký thành công, điều hướng đến một trang khác
                     router.push('/');

                    // window.location.reload(); // Tùy chỉnh theo nhu cầu của bạn
                } else {
                    // Xử lý lỗi không rõ ràng từ backend
                    setError('Something went wrong. Please try again later.');
                }


            }
        } catch (error) {
            // Xử lý lỗi từ API NestJS
            if (error.response) {
                setError(error.response.data.message); // Lấy thông báo lỗi từ phản hồi API
            } else {
                setError('Something went wrong. Please try again later.'); // Lỗi không rõ ràng không có phản hồi từ API
            }
        }
    }

    return (
        <div>
            <Navbar/>
            <div className="  hero min-h-screen bg-base-200">
                <div className="hero-content flex-col lg:flex-row-reverse">
                    <div className=" card w-full max-w-xl flex-shrink-0 bg-base-100 shadow-2xl">
                        <div>
                            <h1 className="pt-10 text-center text-2xl font-bold">
                                CREATE YOUR ACCOUNT
                            </h1>
                        </div>
                        <div className=" card-body px-16 ">
                            <div className="form-control py-1">
                                <input
                                    id="firstName"
                                    type="text"
                                    placeholder="First Name"
                                    name="firstName"
                                    className="input input-bordered "
                                    onChange={(e) => setUser({...user, firstName: e.target.value})}

                                />
                            </div>
                            <div className="form-control py-1 ">
                                <input
                                    id="lastName"
                                    type="text"
                                    placeholder="Last Name"
                                    name="lastName"
                                    className="input input-bordered"
                                    onChange={(e) => setUser({...user, lastName: e.target.value})}

                                />
                            </div>
                            <div className="form-control py-1">
                                <input
                                    id="email"
                                    type="email"
                                    placeholder="Email"
                                    name="email"
                                    className="input input-bordered"
                                    onChange={(e) => setUser({...user, email: e.target.value})}

                                />
                            </div>
                            <div className="form-control py-1">
                                <input
                                    id="password"
                                    type="password"
                                    placeholder="Password"
                                    name="password"

                                    className="input input-bordered"
                                    onChange={(e) => setUser({...user, password: e.target.value})}

                                    // onChange={(e) => setPassword({...password, password: e.target.value})}

                                />
                            </div>
                            <div className="form-control py-1">
                                <input
                                    id="confirmPassword"
                                    type="password"
                                    placeholder="Confirm Password"
                                    name="confirmPassword"
                                    className="input input-bordered"
                                    onChange={(e) => setConfirmPassword(e.target.value)}

                                />
                            </div>
                            <p className="text-center text-red-500">{error}</p>
                            <div className="form-control mt-6">
                                <button type="submit" className="btn btn-success" onClick={onSignUp}>Sign Up
                                </button>

                                <p className="mt-10 text-center">Already have an account?</p>
                                <Link href="/account/login">
                                    <div className="form-control mt-6">
                                        <button className="btn btn-primary">Login</button>
                                    </div>
                                </Link>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Page;
