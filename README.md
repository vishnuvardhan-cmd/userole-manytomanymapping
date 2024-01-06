# userole-manytomanymapping
ManyToMany mapping example

UserController

addUser
request
{
    "userName":"Vishnuvardhan.Bandlamudi@unisys.com",
    "userCreatedBy":"AppExpansionTeam@unisys.com",
    "rolenames":["SUPERADMIN","ADMIN","EDITOR","DEVELOPER"]
}
response
{
    "id": 2,
    "userName": "Vishnuvardhan.Bandlamudi@unisys.com",
    "userCreatedBy": "AppExpansionTeam@unisys.com",
    "userCreatedDate": "2024-01-07T00:21:50.7480022",
    "userModifiedBy": null,
    "userModifiedDate": null,
    "rolenames": [
        "DEVELOPER",
        "ADMIN",
        "EDITOR",
        "SUPERADMIN"
    ]
}

getAllUser
request
LOCALHOST:8086/users
response
[
    {
        "id": 2,
        "userName": "Vishnuvardhan.Bandlamudi@unisys.com",
        "userCreatedBy": "AppExpansionTeam@unisys.com",
        "userCreatedDate": "2024-01-07T00:21:50.748002",
        "userModifiedBy": null,
        "userModifiedDate": null,
        "rolenames": [
            "ADMIN",
            "DEVELOPER",
            "EDITOR",
            "SUPERADMIN"
        ]
    },
    {
        "id": 3,
        "userName": "Sandya.cr@unisys.com",
        "userCreatedBy": "Vishnuvardhan.Bandlamudi@unisys.com",
        "userCreatedDate": "2024-01-07T00:33:46.8938",
        "userModifiedBy": null,
        "userModifiedDate": null,
        "rolenames": [
            "SUPERADMIN"
        ]
    },
    {
        "id": 4,
        "userName": "Apurva.k@unisys.com",
        "userCreatedBy": "Vishnuvardhan.Bandlamudi@unisys.com",
        "userCreatedDate": "2024-01-07T00:34:48.22377",
        "userModifiedBy": null,
        "userModifiedDate": null,
        "rolenames": [
            "ADMIN",
            "EDITOR"
        ]
    }
]

GetUserById

request 
localhost:8086/users/2

response

{
    "id": 2,
    "userName": "Vishnuvardhan.Bandlamudi@unisys.com",
    "userCreatedBy": "AppExpansionTeam@unisys.com",
    "userCreatedDate": "2024-01-07T00:21:50.748002",
    "userModifiedBy": null,
    "userModifiedDate": null,
    "rolenames": [
        "SUPERADMIN",
        "EDITOR",
        "ADMIN",
        "DEVELOPER"
    ]
}

updateUserById

request

{
    "id": 2,
    "userName": "Vishnuvardhan.Bandlamudi@unisys.com",
    "userCreatedBy": "AppExpansionTeam@unisys.com",
    "userCreatedDate": "2024-01-07T00:21:50.748002",
    "userModifiedBy":  "AppExpansionTeam@unisys.com",
    "userModifiedDate": null,
    "rolenames": [
        "SUPERADMIN",
        "EDITOR",
        "ADMIN"
    ]
}

response

{
    "id": 2,
    "userName": "Vishnuvardhan.Bandlamudi@unisys.com",
    "userCreatedBy": "AppExpansionTeam@unisys.com",
    "userCreatedDate": "2024-01-07T00:21:50.748002",
    "userModifiedBy": "AppExpansionTeam@unisys.com",
    "userModifiedDate": "2024-01-07T00:47:15.5262251",
    "rolenames": [
        "SUPERADMIN",
        "ADMIN",
        "EDITOR",
        "DEVELOPER"
    ]
}

deleteUserById

request
localhost:8086/users/4

response
User with given id is deleted successfully

RoleController

saveRole

request
{
    "name":"USER",
    "userNames":["kishore","kranthi"]
}
response
{
    "id": 5,
    "name": "USER",
    "userNames": [
        "kranthi",
        "kishore"
    ]
}

getAllRoles

request
localhost:8086/roles

response
[
    {
        "id": 1,
        "name": "ADMIN",
        "userNames": [
            "Vishnuvardhan.Bandlamudi@unisys.com"
        ]
    },
    {
        "id": 2,
        "name": "EDITOR",
        "userNames": [
            "Vishnuvardhan.Bandlamudi@unisys.com"
        ]
    },
    {
        "id": 3,
        "name": "SUPERADMIN",
        "userNames": [
            "Sandya.cr@unisys.com",
            "Vishnuvardhan.Bandlamudi@unisys.com"
        ]
    },
    {
        "id": 4,
        "name": "DEVELOPER",
        "userNames": [
            "Vishnuvardhan.Bandlamudi@unisys.com"
        ]
    },
    {
        "id": 5,
        "name": "USER",
        "userNames": [
            "kranthi",
            "kishore"
        ]
    }
]

getById

request
localhost:8086/roles/5

response

{
    "id": 5,
    "name": "USER",
    "userNames": [
        "kishore",
        "kranthi"
    ]
}

updateRole

request
{
    "id": 5,
    "name": "USERS",
    "userNames": [
        "kishore",
        "kranthi"
    ]
}

response
{
    "id": 5,
    "name": "USERS",
    "userNames": [
        "kishore",
        "kranthi"
    ]
}

deleteRole

request
localhost:8086/roles/5

response
deleted role successfully with the given Id : 5


