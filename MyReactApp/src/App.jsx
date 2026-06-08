import ArithmeticComponent from "./components/ArithmeticComponent";
import CreateProduct from "./components/createProduct";
import PostList from "./components/PostList";
import Products from "./components/Products";

function App(){ // This is the Parent component in react 

  return(  // This return fn has to be there in every react component. It returns JSX
    <div>
       {/*<ArithmeticComponent /> */} 
       {/*  <Products /> */}
       {/* <CreateProduct /> */}
       <PostList />
    </div>
  )
}

export default App; 
// This is mandatory. If we dont export the fn, we cannot import it anywhere else

/*
JSX : JavaScript Extension (HTML + CSS) : HTML + CSS + JavaScript 
*/