import React from 'react'

export default function Title({name , title}) {
    return (
        <div className="row" style={{ marginTop: 0, marginRight: 0, marginLeft: 0}} >
            <div className="col-10 mx-auto my-2 text-center text-title">
                <h1 className="text-capitalize font-weight-bold">
                    <strong style={{color: '#635772'}}>{name}</strong>  <strong style={{color: '#DB7474'}}>{title}</strong>
                </h1>
            </div>
        </div>
    )
}