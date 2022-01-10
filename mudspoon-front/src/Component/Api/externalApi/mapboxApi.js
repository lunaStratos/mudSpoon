
/**
 * Static image API
 * desc: mapbox
 * */
 export async function geocodingApi(str) {

    const res = await axios.get("https://api.mapbox.com/geocoding/v5/mapbox.places/" + encodeURI(str) + ".json?access_token=pk.eyJ1IjoibHVuYXN0cmF0b3MiLCJhIjoiY2tybXM2MXZnMm5wcjMxbzJ4eDdwZm45diJ9.vf2FoHHxyF7IPDWQfpjgGg")
    return res;
}

/**
 * 주소 부르는 API
 * desc: mapbox
 * */
export async function getAddress (lng, lat) {

    const response = await axios.get("https://api.mapbox.com/geocoding/v5/mapbox.places/"+lng+","+lat+".json?access_token=" + process.env.REACT_APP_MAPBOX_API_KEY);

    let data = {
        country: "",
        address: "",
        shortAddress: ""
    };

    if(!isEmpty(response.data)){
        console.log(response.data);
        if(response.data.features.length !== 0 ){

            let addressText = "";

            for (let index = 0; index < response.data.features.length; index++) {
                const item = response.data.features[index];

                if(item.id.includes("country")){
                    addressText += item.text;
                    data.country = item.properties.short_code; //aq
                }else if(item.id.includes("poi")){
                    //사용안함
                }else{
                    addressText = addressText + item.text + ", ";
                }

            }

            data.address = addressText;
        }else{
            // 바다 혹은 데이터 없는 곳
            data.address = "sea";
            data.country = "aqua";
        }
    }

    return data;
}
