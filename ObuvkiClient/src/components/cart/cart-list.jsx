import CartItem from './cart-item.jsx';

export default function CartList({value}) {
    const { cart} =value;
   
    return (
     <div className="container-fluid">
         {cart.map(item=>{
             return <CartItem key={item.id} item={item} value={value}/>
         })}
    </div>
    );
}