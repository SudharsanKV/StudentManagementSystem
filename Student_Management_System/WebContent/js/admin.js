// function hide(id){
//     idName = ['home','studentlist','editmarks','addstudent','stafflist','addstaff'];
//     idName.forEach(element => {
//         if(element != id){
//             document.getElementById(element).classList.add('hide');
//         }else{
//             if(document.getElementById(element).classList){
//                 document.getElementById(element).classList.remove('hide');
//             }
//         }
        
//     });
// }

var students = [
    {sdname:"Anbu", sdgender:"Male", sddept:"AGRI", sdemail:"anbu@gamil.com",
    sdfname:"vetri", sdfmobile:"963214870", sdmname:"veni", sdmmobile:"9785463210", sdaddress:"xyz",
    sem1:"8", sem2:"8", sem3:"8", sem4:"8", sem5:"8", sem6:"8", sem7:"8", sem8:"8"},

    {sdname:"dinesh", sdgender:"Male", sddept:"CIVIL", sdemail:"dinesh@gamil.com",
    sdfname:"maaran", sdfmobile:"963214870", sdmname:"madhu", sdmmobile:"9785463210", sdaddress:"xyz",
    sem1:"8", sem2:"8", sem3:"8", sem4:"8", sem5:"8", sem6:"8", sem7:"8", sem8:"8"}
]
var studentslist = [
    {name:"Anbu", gender:"Male", dept:"AGRI", email:"anbu@gamil.com",
    sem1:"8", sem2:"8", sem3:"8", sem4:"8", sem5:"8", sem6:"8", sem7:"8", sem8:"8"},

    {name:"dinesh", gender:"Male", dept:"CIVIL", email:"dinesh@gamil.com",
    sem1:"8", sem2:"8", sem3:"8", sem4:"8", sem5:"8", sem6:"8", sem7:"8", sem8:"8"}
]

function addStudent(){
    let student ={
    sdname: document.getElementById("sdname").value,
    sdgender: document.getElementById("sdgender").value,
    sddept: document.getElementById("sddept").value,
    sdemail: document.getElementById("sdemailid").value,
    sdfname: document.getElementById("sdfname").value,
    sdfmobile: document.getElementById("sdfmobile").value,
    sdmname: document.getElementById("sdmname").value,
    sdmmobile: document.getElementById("sdmmobile").value,
    sdaddress: document.getElementById("sdaddress").value,
    sem1: "0", sem2: "0", sem3: "0", sem4: "0", sem5: "0", sem6: "0", sem7: "0", sem8: "0"
    };
    students.push(student);
    let studentlist ={
        name: document.getElementById("sdname").value,
        gender: document.getElementById("sdgender").value,
        dept: document.getElementById("sddept").value,
        email: document.getElementById("sdemailid").value,
        sem1: "0", sem2: "0", sem3: "0", sem4: "0", sem5: "0", sem6: "0", sem7: "0", sem8: "0"
    };
    studentslist.push(studentlist);
    alert('Student information has been added to the data base');
}
var staffs = [
    {stname:"Ravi", stgender:"Male", stdept:"AUTO", stemail:"ravi@gmail.com",
    stmobile:"963214870", stdoj:"02/24/2021", stsalary:"10000", staddress:"xyz"},

    {stname:"Sona", stgender:"Female", stdept:"ECE", stemail:"sona@gamil.com",
    stmobile:"963214870", stdoj:"06/15/2018", stsalary:"16000", staddress:"xyz"}
]
var staffslist =[
    {name:'Ravi', gender:'Male', dept:'AUTO', email:'ravi@gmail.com', doj:"02/24/2021", salary:"10000"},
    {name:'Sona', gender:'Female', dept:'ECE', email:'sona@gmail.com', doj:"06/15/2018", salary:"16000"}
]

function addStaff(){
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
        doj: document.getElementById("stdoj").value,
        salary: document.getElementById("stsalary").value
    };
    staffslist.push(stafflist);
    alert('Staff information has been added to the data base');
}

let myTable = document.querySelector('#table');
let btnget = document.querySelector('#but');
let headers = ['Name', 'Gender', 'Mail', 'Department', 'Date of Joining'];
btnget.addEventListener('click', () => {
    let table= document.createElement('table');
    let headerRow=document.createElement('tr');
    headers.forEach(headerText => {
        let header =document.createElement('th');
        let textNode= document.createTextNode(headerText);
        header.appendChild(textNode);
        headerRow.appendChild(header);
    });
    table.appendChild(headerRow);

    staffslist.forEach(staff =>{
        let row = document.createElement('tr');
        Object.values(staff).forEach(text =>{
            let cell =document.createElement('td');
            let textNode= document.createTextNode(text);
            cell.appendChild(textNode);
            row.appendChild(cell); 
        })
        table.appendChild(row);
    });
    myTable.appendChild(table);
    document.getElementById('firststaff').style.display='block';
});



// var count=0;
// let myTable = document.querySelector('#table');
// let btnget = document.querySelector('#but');
// let headers = ['Name', 'Gender', 'Mail', 'Department', 'Date of Joining'];
// btnget.addEventListener('click', () => {
//     staffslist.forEach(stafflist =>{
//             let row = document.createElement('tr');
//             Object.values(stafflist).forEach( staff =>{
//                 let cell = document.createElement('td');
//                 let textNode = document.createTextNode(staff);
//                 cell.appendChild(textNode);
//                 row.appendChild(cell);
//                 count++;
//         })
//         myTable.appendChild(row);
//     });


//     let table= document.createElement('table');
//     let headerRow=document.createElement('tr');
//     headers.forEach(headerText => {
//         let header =document.createElement('th');
//         let textNode= document.createTextNode(headerText);
//         header.appendChild(textNode);
//         headerRow.appendChild(header);
//     });
//     table.appendChild(headerRow);

//     staffslist.forEach(stafflist =>{
//         let row = document.createElement('tr');
//         Object.values(stafflist).forEach(text =>{
//             let cell =document.createElement('td');
//             let textNode= document.createTextNode(text);
//             cell.appendChild(textNode);
//             row.appendChild(cell); 
//         })
//         table.appendChild(row);
//     });
//     myTable.appendChild(table);
//     // document.getElementById('butstaff').style.display='block';
// });



