import axios from "axios";

const listBooks = () => axios.get('http://localhost:8080/books')
    .then((response) => {
        console.log(response.data);
    });

const createBook = () => axios.post(
    'http://localhost:8080/books',
    {
        "name": "Test Book",
        "authorName": "First Name",
        "imageUrl": "https://picsum.photos/200",
        "price" : {
            "currency" : "INR" ,
            "amount" : 100
        }
    })
    .then((response) => {
        console.log(response.data);
    });

const updateBook = () => axios.put(
    'http://localhost:8080/books/1',
    {
        "imageUrl": "https://picsum.photos/200",
        "amount": 10
    })
    .then((response) => {
        console.log(response.data);
    });

const removeBook = () => axios.delete('http://localhost:8080/books/1')
    .then((response) => {
        console.log(response.data);
    });

listBooks().then(createBook).then(listBooks).then(updateBook).then(listBooks).then(removeBook).then(listBooks)