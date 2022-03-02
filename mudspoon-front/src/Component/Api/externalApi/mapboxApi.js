
import axios from 'axios';

/**
 * Static image API
 * desc: mapbox
 * */
 export async function geocodingApi(str) {

    const res = await axios.get("https://api.mapbox.com/geocoding/v5/mapbox.places/" + encodeURI(str) + ".json?access_token=pk.eyJ1IjoibHVuYXN0cmF0b3MiLCJhIjoiY2tybXM2MXZnMm5wcjMxbzJ4eDdwZm45diJ9.vf2FoHHxyF7IPDWQfpjgGg")
    return res;
}
