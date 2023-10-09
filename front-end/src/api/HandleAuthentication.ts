
import axiosClient from "@/api/axiosClient";
import {BASE_URL} from "@/constant/appInfo";
import {Authentication} from "@/models/Authentication";

class HandleAuthentication {
    static postLogin = async (url: string, data: Authentication[])=>{
        return axiosClient.post(BASE_URL +url,data)
    }


}


export default HandleAuthentication