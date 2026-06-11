import { Route, Routes } from "react-router-dom";
import Home from "./pages/Home";
import Auth from "./pages/Auth";
import PageNotFound from "./pages/PageNotFound";
import OfficerDashboard from "./pages/OfficerDashboard";
import StationHeadDashboard from "./pages/StationHeadDashboard";
import OfficerOnboard from "./components/station_head/OfficerOnboard";
import Widget from "./components/station_head/Widget";

const App = ()=>{

  return(
    <div>
      <Routes>
        <Route path="/" element={<Home />}></Route>
        <Route path="/login" element={<Auth />}></Route>
        <Route path="/officer" element={<OfficerDashboard />}></Route>
        <Route path="/station-head" element={<StationHeadDashboard />}>
            <Route path="" element={<Widget />}></Route>
            <Route path="officer-onboard" element={<OfficerOnboard />}></Route>
        </Route>
        <Route path="/officer-onboard" element={<OfficerOnboard />}></Route>
        
        <Route path="*" element={<PageNotFound />}></Route>
      </Routes>
    </div>
  )

}

export default App; 