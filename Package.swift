// swift-tools-version:5.3
// The swift-tools-version declares the minimum version of Swift required to build this package.

import PackageDescription

let package = Package(
    name: "ZoomMeetingSDK",
    platforms: [.iOS(.v14)],
    products: [
        // Products define the executables and libraries a package produces, and make them visible to other packages.
        .library(
            name: "ZoomMeetingSDK",
            targets: ["MobileRTC", "zoomcml"]
        ),
        .library(
            name: "ZoomScreenShareSDK",
            targets: ["MobileRTCScreenShare"]
        )
    ],
    dependencies: [],
    targets: [
        .binaryTarget(
            name: "MobileRTC",
            url: "https://github.com/hello-sunrise/zoom-meeting-sdk/releases/download/5.16.2/MobileRTC.xcframework.zip",
            checksum: "8c56d7be8cb404a335c848da8b8370e53174448951722694b913b9e7a63dd36b"
        ),
        .binaryTarget(
            name: "MobileRTCScreenShare",
            url: "https://github.com/hello-sunrise/zoom-meeting-sdk/releases/download/5.16.2/MobileRTCScreenShare.xcframework.zip",
            checksum: "3f829277429de334be3a379c9de22402e6e5e11b351428a63bd5be48cbbb9e46"
        ),
        .binaryTarget(
            name: "zoomcml",
            url: "https://github.com/hello-sunrise/zoom-meeting-sdk/releases/download/5.16.2/zoomcml.xcframework.zip",
            checksum: "3348049176ef894e1ca283a77b3e669f4956cd6a3e31cc5d945df66ec7127f95"
        ),
    ]
)
