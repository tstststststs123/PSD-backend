# PSD-backend

test:
curl --location --request POST 'http://localhost:8093/api/hiker' --header 'Content-Type: application/json' --data-raw '{ "name": "Kean", "identityNo": "123123", "contactNo": "012-34567899", "date": "12-11-2022", "hillName": "Gasing Hill" }'
