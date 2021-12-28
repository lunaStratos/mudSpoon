import {atom, selector} from "recoil";

export const DataStore = atom({
    key: 'DataStore',
    default: 0
});

export const DataSelector = selector({
    key: 'DataSelector',
    get: ({ get }) => {
        const value = get(DataStore);
        return value;
    }
});

/**
 * [적용법]
 * 
 * value Send : const [mapStore, setMapStore] = useRecoilState(DataStore)
 * value Get: const geocodingData = useRecoilValue(DataSelector);
 */