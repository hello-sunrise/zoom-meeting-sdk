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
            targets: ["MobileRTC"]
        ),
    ],
    dependencies: [],
    targets: [
        .binaryTarget(
            name: "MobileRTC",
            url: "https://github.com/hello-sunrise/zoom-meeting-sdk/releases/download/5.15.12/MobileRTC.xcframework.zip",
            checksum: "9347f8c81e0caecece70807d51446adc5e4129d220c252f25fc6c4eee7d2ea15"
        ),
    ]
)
