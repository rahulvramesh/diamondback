<!DOCTYPE html>
<!-- saved from url=(0081)http://ec2contai-ecselast-1odt0hji1ptrd-903851155.us-west-1.elb.amazonaws.com/etl -->
<html lang="en"><script id="tinyhippos-injected">if (window.top.ripple) { window.top.ripple("bootstrap").inject(window, document); }</script><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>hello</title>

        <link rel="stylesheet" href="/resources/bootstrap.min.css">
        
        <link rel="shortcut icon" type="image/png" href="http://ec2contai-ecselast-1odt0hji1ptrd-903851155.us-west-1.elb.amazonaws.com/assets/images/favicon.png">

        <link rel="stylesheet" media="screen" href="/resources/css/fine-uploader-gallery.min.css">
            <!-- Loading Bootstrap -->
        <link href="/resources/css/bootstrap.min(1).css" rel="stylesheet">

            <!-- Loading Flat UI -->
        <link href="/resources/css/flat-ui.css" rel="stylesheet">


            <!-- HTML5 shim, for IE6-8 support of HTML5 elements. All other JS at the end of file. -->
            <!--[if lt IE 9]>
	      	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
    </head>
    <body cz-shortcut-listen="true">

        <script type="text/javascript" src="/resources/js/jquery.min.js"></script>
        <script type="text/javascript" src="/resources/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="/resources/js/flat-ui.min.js"></script>
        <script type="text/javascript" src="/resources/js/react.js"></script>
        <script type="text/javascript" src="/resources/js/JSXTransformer.js"></script>
        <script type="text/javascript" src="/resources/js/marked.js"></script>

        <div class="container">
        
    
        
            <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">

            <link href="/resources/css/fine-uploader-gallery.min.css" rel="stylesheet">

            <script src="/resources/js/s3.fine-uploader.min.js" type="text/javascript"></script>
            <script type="text/template" id="qq-template-s3">
            <div class="qq-uploader-selector qq-uploader qq-gallery" qq-drop-area-text="Drop files here">
            <div class="qq-total-progress-bar-container-selector qq-total-progress-bar-container">
            <div role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" class="qq-total-progress-bar-selector qq-progress-bar qq-total-progress-bar"></div>
            </div>
            <div class="qq-upload-drop-area-selector qq-upload-drop-area" qq-hide-dropzone>
            <span class="qq-upload-drop-area-text-selector"></span>
            </div>
            <div class="qq-upload-button-selector qq-upload-button">
            <div>Upload a file</div>
            </div>
            <span class="qq-drop-processing-selector qq-drop-processing">
            <span>Processing dropped files...</span>
            <span class="qq-drop-processing-spinner-selector qq-drop-processing-spinner"></span>
            </span>
            <ul class="qq-upload-list-selector qq-upload-list" role="region" aria-live="polite" aria-relevant="additions removals">
            <li>
            <span role="status" class="qq-upload-status-text-selector qq-upload-status-text"></span>
            <div class="qq-progress-bar-container-selector qq-progress-bar-container">
            <div role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" class="qq-progress-bar-selector qq-progress-bar"></div>
            </div>
            <span class="qq-upload-spinner-selector qq-upload-spinner"></span>
            <div class="qq-thumbnail-wrapper">
            <a class="preview-link" target="_blank">
            <img class="qq-thumbnail-selector" qq-max-size="120" qq-server-scale>
            </a>
            </div>
            <button type="button" class="qq-upload-cancel-selector qq-upload-cancel">X</button>
            <button type="button" class="qq-upload-retry-selector qq-upload-retry">
            <span class="qq-btn qq-retry-icon" aria-label="Retry"></span>
            Retry
            </button>

            <div class="qq-file-info">
            <div class="qq-file-name">
            <span class="qq-upload-file-selector qq-upload-file"></span>
            <span class="qq-edit-filename-icon-selector qq-edit-filename-icon" aria-label="Edit filename"></span>
            </div>
            <input class="qq-edit-filename-selector qq-edit-filename" tabindex="0" type="text">
            <span class="qq-upload-size-selector qq-upload-size"></span>
            <button type="button" class="qq-btn qq-upload-delete-selector qq-upload-delete">
            <span class="qq-btn qq-delete-icon" aria-label="Delete"></span>
            </button>
            <button type="button" class="qq-btn qq-upload-pause-selector qq-upload-pause">
            <span class="qq-btn qq-pause-icon" aria-label="Pause"></span>
            </button>
            <button type="button" class="qq-btn qq-upload-continue-selector qq-upload-continue">
            <span class="qq-btn qq-continue-icon" aria-label="Continue"></span>
            </button>
            </div>
            </li>
            </ul>

            <dialog class="qq-alert-dialog-selector">
            <div class="qq-dialog-message-selector"></div>
            <div class="qq-dialog-buttons">
            <button type="button" class="qq-cancel-button-selector">Close</button>
            </div>
            </dialog>

            <dialog class="qq-confirm-dialog-selector">
            <div class="qq-dialog-message-selector"></div>
            <div class="qq-dialog-buttons">
            <button type="button" class="qq-cancel-button-selector">No</button>
            <button type="button" class="qq-ok-button-selector">Yes</button>
            </div>
            </dialog>

            <dialog class="qq-prompt-dialog-selector">
            <div class="qq-dialog-message-selector"></div>
            <input type="text">
            <div class="qq-dialog-buttons">
            <button type="button" class="qq-cancel-button-selector">Cancel</button>
            <button type="button" class="qq-ok-button-selector">Ok</button>
            </div>
            </dialog>
            </div>
            </script>

            <style>
            #fine-uploader-s3.preview-link {
            display: block ;
            height: 100% ;
            width: 100% ;
            }
            </style>

            <title>Fine Uploader S3 Demo</title>
        
        
        <h1>Please only upload files with extension .zip </h1>
            <div id="fine-uploader-s3"><div class="qq-uploader-selector qq-uploader qq-gallery" qq-drop-area-text="Drop files here">
            <div class="qq-total-progress-bar-container-selector qq-total-progress-bar-container qq-hide">
            <div role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" class="qq-total-progress-bar-selector qq-progress-bar qq-total-progress-bar"></div>
            </div>
            <div class="qq-upload-drop-area-selector qq-upload-drop-area" qq-hide-dropzone="" style="display: none;">
            
            </div>
            <div class="qq-upload-button-selector qq-upload-button" style="position: relative; overflow: hidden; direction: ltr;">
            <div>Upload a file</div>
            <input qq-button-id="1b3230fa-df91-4fea-afc9-2ed57dc987d7" title="file input" multiple="" type="file" name="qqfile" style="position: absolute; right: 0px; top: 0px; font-family: Arial; font-size: 118px; margin: 0px; padding: 0px; cursor: pointer; opacity: 0; height: 100%;"></div>
            <span class="qq-drop-processing-selector qq-drop-processing qq-hide">
            <span>Processing dropped files...</span>
            <span class="qq-drop-processing-spinner-selector qq-drop-processing-spinner"></span>
            </span>
            <ul class="qq-upload-list-selector qq-upload-list" role="region" aria-live="polite" aria-relevant="additions removals"></ul>

            <dialog class="qq-alert-dialog-selector">
            <div class="qq-dialog-message-selector"></div>
            <div class="qq-dialog-buttons">
            <button type="button" class="qq-cancel-button-selector">Close</button>
            </div>
            </dialog>

            <dialog class="qq-confirm-dialog-selector">
            <div class="qq-dialog-message-selector"></div>
            <div class="qq-dialog-buttons">
            <button type="button" class="qq-cancel-button-selector">No</button>
            <button type="button" class="qq-ok-button-selector">Yes</button>
            </div>
            </dialog>

            <dialog class="qq-prompt-dialog-selector">
            <div class="qq-dialog-message-selector"></div>
            <input type="text">
            <div class="qq-dialog-buttons">
            <button type="button" class="qq-cancel-button-selector">Cancel</button>
            <button type="button" class="qq-ok-button-selector">Ok</button>
            </div>
            </dialog>
            </div></div>
            <script>
                    var uploader = new qq.s3.FineUploader({
                        debug: true,
                        element: document.getElementById('fine-uploader-s3'),
                        template: 'qq-template-s3',
                        request: {
                            endpoint: 'diamondback-epocs-zip.s3.amazonaws.com',
                            accessKey: 'AKIAJCNREYL7KSUNFYEA'
                        },
                        signature: {
                            endpoint: '/s3/signature'
                        },
                        uploadSuccess: {
                            endpoint: '/s3/success'
                        },
                        iframeSupport: {
                            localBlankPagePath: '/success.html'
                        },
                        retry: {
                            enableAuto: true // defaults to false
                        },
                        resume: {
                            enabled: true
                        },
                        chunking: {
                            enabled: true
                        },
                        cors: {
                            enabled: true
                        },
                        validation: {
                            allowedExtensions: ['zip']
                        },
                        thumbnails: {
                            placeholders: {
                                notAvailablePath: "/assets/images/placeholders/not_available-generic.png",
                                waitingPath: "/assets/images/placeholders/waiting-generic.png"
                            }
                        },
                        callbacks: {
                            onComplete: function(id, name, response) {
                                var previewLink = qq(this.getItemByFileId(id)).getByClass('preview-link')[0];

                                if (response.success) {
                                    previewLink.setAttribute("href", response.tempLink)
                                }
                            }
                        },
                        deleteFile: {
                            enabled: false,
                            endpoint: '/s3handler'
                        }
                    });
            </script>

        
    

        </div>

    

<object id="__symantecPKIClientMessenger" style="display: none;"></object><span id="__symantecPKIClientDetector" style="display: none;">__PRESENT</span></body></html>