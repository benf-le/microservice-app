import React from "react";
import Link from "next/link";

export default function Navbar(props) {
    return (
        <div>
            <header className="h-20">
                <div
                    className=" pet-stock-color navbar  flex h-20 flex-grow bg-base-100 fixed left-0 right-0 top-0 z-10 ">

                    <div className="basis-1/4 justify-center">
                        <Link href="/" className="btn btn-ghost text-xl text-white">LIBRARY</Link>
                    </div>


                    <div className="basis-1/2">
                        <input
                            type="text"
                            placeholder="Search"
                            className="input input-bordered w-full"
                        />
                    </div>
                    <div className="basis-1/4 justify-center">
                        <Link href="/account/login">
                            <button className="btn btn-ghost text-white">
                                <svg
                                    xmlns="http://www.w3.org/2000/svg"
                                    fill="none"
                                    viewBox="0 0 24 24"
                                    strokeWidth={1.5}
                                    stroke="currentColor"
                                    className="h-6 w-6"
                                >
                                    <path
                                        strokeLinecap="round"
                                        strokeLinejoin="round"
                                        d="M15.75 6a3.75 3.75 0 11-7.5 0 3.75 3.75 0 017.5 0zM4.501 20.118a7.5 7.5 0 0114.998 0A17.933 17.933 0 0112 21.75c-2.676 0-5.216-.584-7.499-1.632z"
                                    />
                                </svg>
                                Login
                            </button>
                        </Link>

                    </div>
                </div>
            </header>



        </div>
    );
}
