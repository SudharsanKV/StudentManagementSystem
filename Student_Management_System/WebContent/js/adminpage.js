function addStaff(){
    alert('Staff information has been added to the data base');
    let staff ={
        stname: document.getElementById("stname").value,
        stgender: document.getElementById("stgender").value,
        stdept: document.getElementById("stdept").value,
        stemail: document.getElementById("stemailid").value,
        stmobile: document.getElementById("stmobile").value,
        stdoj: document.getElementById("stdoj").value,
        stsalary: document.getElementById("stsalary").value,
        staddress: document.getElementById("staddress").value
    };
    staffs.push(staff);
    let stafflist ={
        name: document.getElementById("stname").value,
        gender: document.getElementById("stgender").value,
        dept: document.getElementById("stdept").value,
        email: document.getElementById("stemailid").value,
        doj: document.getElementById("styoj").value,
        salary: document.getElementById("stsalary").value
    };
    staffslist.push(stafflist);
}