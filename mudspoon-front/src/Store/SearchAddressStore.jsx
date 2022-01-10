import {atom, selector} from "recoil";

/**
 * 주소검색 및 searchBox 에서 사용
 *
 * History:
 *    LunaStratos, 1.0, 2022-01-10 초기작성
 *
 * @date        2022-01-10
 * @version     1.0
 * @author      LunaStratos (LunaStratos@gmail.com)
 */
export const SearchAddressState = atom({
    key: 'SearchAddressState',
    default: {
        longitude : 127,
        latitude: 37,
        productId: -1
    }
});

export const SearchAddressSelector = selector({
    key: 'SearchAddressSelector',
    get: ({ get }) => {
        const value = get(SearchAddressState);
        return [value.longitude, value.latitude, value.productId];
    }
});


export const SearchGPSState = atom({
    key: 'SearchGPSState',
    default: 0
});

export const SearchGPSSelector = selector({
    key: 'SearchGPSSelector',
    get: ({ get }) => {
        const value = get(SearchGPSState);
        return value;
    }
});


export const SearchGPSComplateState = atom({
    key: 'SearchGPSState',
    default: 0
});

export const SearchGPSComplateSelector = selector({
    key: 'SearchGPSComplateSelector',
    get: ({ get }) => {
        const value = get(SearchGPSComplateState);
        return value;
    }
});
