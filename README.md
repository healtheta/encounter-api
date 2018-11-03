# Encounter-Api

**Create**
----
 Create a encounter resource in the platform

* **URL**

http://host.name/condition/create

* **Method:**
  
  `POST`
  
  * **Data Params**
```javascript
{
    "id": null,
    "identifier": {
        "id": null,
        "use": value,
        "type": value,
        "system": value,
        "value": value,
        "period": value,
        "assigner": value
    },
    "clinicalStatus": value,
    "verificationStatus": value,
    "category": value,
    "severity": value,
    "code": value,
    "bodySite": value,
    "subject": value,
    "context": value,
    "onset": value,
    "abatement": value,
    "assertedDate": value,
    "asserter": value,
    "stage": value,
    "evidence": value,
    "reference": value,
    "note": value
}
```
* **Success Response:**  
  
  
*  **URL Params**

  * **Code:** 200 <br />
    **Content:** 
```javascript
{
    "id": assigned id,
    "identifier": {
        "id": value,
        "use": value,
        "type": value,
        "system": value,
        "value": value,
        "period": value,
        "assigner": value
    },
    "clinicalStatus": value,
    "verificationStatus": value,
    "category": value,
    "severity": value,
    "code": value,
    "bodySite": value,
    "subject": value,
    "context": value,
    "onset": value,
    "abatement": value,
    "assertedDate": value,
    "asserter": value,
    "stage": value,
    "evidence": value,
    "reference": value,
    "note": value
}
```

* **Error Response:**

  * **Code:** 422 INVALID PARAMETER <br />
    **Content:** `{ severity : "error", "code":"422", "details":"invalid parameter", "diagnostic":null, "expression": null, "location":null }`
    
  * **Code:** 409 RECORD EXISTS <br />
    **Content:** `{ severity : "error", "code":"409", "details":"record exists", "diagnostic":null, "expression": null, "location":null }`    

  * **Code:** 500 INTERNAL ERROR <br />
    **Content:** `{ severity : "error", "code":"500", "details":"internal error", "diagnostic":null, "expression": null, "location":null }` 


**Read**
----
 Read a encounter resource from the platform

* **URL**

http://host.name/condition/read/{id}

* **Method:**
  
  `GET`
  
    * **Data Params**
     **Required:**
 
   `id=[Long]`
  
* **Success Response:**  
  
  
*  **URL Params**

  * **Code:** 200 <br />
    **Content:** 
```javascript
{
    "id": assigned id,
    "identifier": {
        "id": value,
        "use": value,
        "type": value,
        "system": value,
        "value": value,
        "period": value,
        "assigner": value
    },
    "clinicalStatus": value,
    "verificationStatus": value,
    "category": value,
    "severity": value,
    "code": value,
    "bodySite": value,
    "subject": value,
    "context": value,
    "onset": value,
    "abatement": value,
    "assertedDate": value,
    "asserter": value,
    "stage": value,
    "evidence": value,
    "reference": value,
    "note": value
}
```

* **Error Response:**

  * **Code:** 422 INVALID PARAMETER <br />
    **Content:** `{ severity : "error", "code":"422", "details":"invalid parameter", "diagnostic":null, "expression": null, "location":null }`
    
  * **Code:** 409 RECORD EXISTS <br />
    **Content:** `{ severity : "error", "code":"409", "details":"record exists", "diagnostic":null, "expression": null, "location":null }`    

  * **Code:** 500 INTERNAL ERROR <br />
    **Content:** `{ severity : "error", "code":"500", "details":"internal error", "diagnostic":null, "expression": null, "location":null }` 


**Update**
----
 Update a encounter resource in the platform

* **URL**

http://host.name/condition/update

* **Method:**
  
  `POST`
  
  * **Data Params**
```javascript
{
    "id": value,
    "identifier": {
        "id": null,
        "use": value,
        "type": value,
        "system": value,
        "value": value,
        "period": value,
        "assigner": value
    },
    "clinicalStatus": value,
    "verificationStatus": value,
    "category": value,
    "severity": value,
    "code": value,
    "bodySite": value,
    "subject": value,
    "context": value,
    "onset": value,
    "abatement": value,
    "assertedDate": value,
    "asserter": value,
    "stage": value,
    "evidence": value,
    "reference": value,
    "note": value
}
```
* **Success Response:**  
  
  
*  **URL Params**

  * **Code:** 200 <br />
    **Content:** 
```javascript
{
    "id": id,
    "identifier": {
        "id": value,
        "use": value,
        "type": value,
        "system": value,
        "value": value,
        "period": value,
        "assigner": value
    },
    "clinicalStatus": value,
    "verificationStatus": value,
    "category": value,
    "severity": value,
    "code": value,
    "bodySite": value,
    "subject": value,
    "context": value,
    "onset": value,
    "abatement": value,
    "assertedDate": value,
    "asserter": value,
    "stage": value,
    "evidence": value,
    "reference": value,
    "note": value
}
```

* **Error Response:**

  * **Code:** 422 INVALID PARAMETER <br />
    **Content:** `{ severity : "error", "code":"422", "details":"invalid parameter", "diagnostic":null, "expression": null, "location":null }`
    
  * **Code:** 409 RECORD EXISTS <br />
    **Content:** `{ severity : "error", "code":"409", "details":"record exists", "diagnostic":null, "expression": null, "location":null }`    

  * **Code:** 500 INTERNAL ERROR <br />
    **Content:** `{ severity : "error", "code":"500", "details":"internal error", "diagnostic":null, "expression": null, "location":null }` 
    
**Search**
----
 Search encounter resources from a given search criteria

* **URL**

http://host.name/condition/read?subjec=&|context=|}

* **Method:**
  
  `GET`
  
    * **Data Params**
 
   `subject=[<patient | Group> reference id]`
   
   `context=[<Encounter | Episode of Care> reference id]`
  
* **Success Response:**  

  
*  **URL Params**

  * **Code:** 200 <br />
    **Content:** 
  List of conditions complying to search criteria

* **Error Response:**

  * **Code:** 422 INVALID PARAMETER <br />
    **Content:** `{ severity : "error", "code":"422", "details":"invalid parameter", "diagnostic":null, "expression": null, "location":null }`
    
  * **Code:** 410 RECORD EXISTS <br />
    **Content:** `{ severity : "error", "code":"410", "details":"record not found", "diagnostic":null, "expression": null, "location":null }`    

  * **Code:** 500 INTERNAL ERROR <br />
    **Content:** `{ severity : "error", "code":"500", "details":"internal error", "diagnostic":null, "expression": null, "location":null }`     
    
    



