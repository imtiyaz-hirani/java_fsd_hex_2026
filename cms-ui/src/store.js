import { configureStore } from "@reduxjs/toolkit";
import { incidentReducer } from "./store/reducer/incidentReducar";

export const store = configureStore({
  reducer: {
    incidents: incidentReducer,
    
  }
})